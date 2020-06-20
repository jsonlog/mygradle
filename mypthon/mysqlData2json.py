# -*- coding=utf-8 -*-
import MySQLdb
import warnings
import datetime
import sys
import json
reload(sys)
sys.setdefaultencoding('utf8')
 
warnings.filterwarnings("ignore")
 
mysqlDb_config = {
    'host': 'MysqlHostIp',
    'user': 'MysqlUser',
    'passwd': 'MysqlPass',
    'port': 50512,
    'db': 'Tv_event'
}
 
today = datetime.date.today()
yesterday = today - datetime.timedelta(days=1)
tomorrow = today + datetime.timedelta(days=1)
 
def getDB(dbConfigName):
    dbConfig = eval(dbConfigName)
    try:
        conn = MySQLdb.connect(host=dbConfig['host'], user=dbConfig['user'], passwd=dbConfig['passwd'],
                               port=dbConfig['port'])
        conn.autocommit(True)
        curr = conn.cursor()
        curr.execute("SET NAMES utf8");
        curr.execute("USE %s" % dbConfig['db']);
 
        return conn, curr
    except MySQLdb.Error, e:
        print "Mysql Error %d: %s" % (e.args[0], e.args[1])
        return None, None
 
def mysql2json(dbConfigName, selectSql, jsonPath, fileName):
    conn, curr = getDB(dbConfigName)
    curr.execute(selectSql)
    datas = curr.fetchall()
    fields = curr.description
 
    column_list = []
    for field in fields:
        column_list.append(field[0])
 
    with open('{jsonPath}{fileName}.json'.format(jsonPath=jsonPath, fileName=fileName), 'w+') as f:
        for row in datas:
            result = {}
            for fieldIndex in range(0, len(column_list)):
                result[column_list[fieldIndex]] = str(row[fieldIndex])
            jsondata=json.dumps(result, ensure_ascii=False)
            f.write(jsondata + '\n')
    f.close()
 
    curr.close()
    conn.close()
 
# Batch Test
dbConfigName = 'mysqlDb_config'
selectSql = "SELECT uid,name,phone_num,qq,area,created_time FROM match_apply where match_id = 83 order by created_time desc;"
jsonPath = '/Users/nisj/Desktop/'
fileName = 'mysql2json'
mysql2json(dbConfigName, selectSql, jsonPath, fileName)