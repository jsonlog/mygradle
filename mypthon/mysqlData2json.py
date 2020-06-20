#!/usr/bin/env python
# coding=utf-8
from __future__ import absolute_import
from __future__ import division
from __future__ import print_function
import json
import pymysql
import datetime

# datetimeTypeError: datetime.datetime(2017, 3, 21, 2, 11, 21) is not JSON serializable。
class CJsonEncoder(json.JSONEncoder):
    def default(self, obj):
        if isinstance(obj, datetime.datetime):
            return obj.strftime('%Y-%m-%d %H:%M:%S')
        elif isinstance(obj, date):
            return obj.strftime("%Y-%m-%d")
        else:
            return json.JSONEncoder.default(self, obj)

# 连接数据库
conn = pymysql.connect(
            host='localhost',
            user='root',
            passwd='123456',
            db='life',
            charset='utf8',
            use_unicode=True
        )
# 建立游标cursor
cursor = conn.cursor()

# 执行查
cursor.execute("SELECT * FROM what")
# 查询数据库多条数据
result = cursor.fetchall()
# for data in result:
#     print(data)
# (1, '李华', '123456', '上海')
# (2, '王明', '123456', '北京')
# (3, '杨一', '1234', '杭州')

fields = cursor.description
# print(fields)
# (('Id', 3, None, 11, 11, 0, False), ('name', 253, None, 25, 25, 0, True),
# ('password', 253, None, 255, 255, 0, True), ('birthplace', 253, None, 255, 255, 0, True))

cursor.close()
conn.close()

# 定义字段名的列表
column_list = []
for i in fields:
    # 提取字段名，追加到列表中
    column_list.append(i[0])
    # print('"\n    },\n    {\n      "field": "',end="")
    # print(i[0],end="")
    # print('",\n      "title": "',end="")
    # print(i[0],end="")
print(column_list)
# ['Id', 'name', 'password', 'birthplace']

# 打开输出结果文件
with open('json.data', 'w+') as f:
    # 一次循环，row代表一行，row以元组的形式显示
    for row in result:
        # 定义Python 字典
        data = {}
        # 将row中的每个元素，追加到字典中。
        for i in range(len(column_list)):
            data[column_list[i]] = row[i]
        # print(data)
        # data[column_list[0]] = row[0]
        # # Python字段格式 和json字段格式转换
        # data[column_list[1]] = str(row[1])
        # data[column_list[2]] = str(row[2])
        # data[column_list[3]] = str(row[3])
        # Python的dict --转换成----> json的object
        jsondata = json.dumps(data, cls=CJsonEncoder) #,ensure_ascii=False)
        # 写入文件
        f.write(jsondata + ',\n')
f.close()