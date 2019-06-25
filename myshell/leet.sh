# bin/sh
# 192
# cat words.txt |xargs |sed "s/ /\n/g"|sort|uniq -c|sort -r|awk '{print $2" "$1}'

# ref:  sed ':a;N;$!ba;s/\n/ /g' file
# all:  sed -e ':a' -e 'N' -e '$!ba' -e 's/\n/ /g' file

echo ""

cat words.txt |awk '{for(i=1;i<=NF;i++) print $i;}'|sort|uniq -c|sort -r |awk '{print $2, $1}'

echo ""

cat words.txt|xargs -n 1|sort|uniq -c|sort -nr|awk '{print $2" "$1}'

echo ""

cat words.txt | tr ' ' '\n' |sort| grep .| uniq -c | sort -r -n -k 1| awk '{print $2,$1}'

echo ""


# 193
awk '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/' file193.txt

echo ""

# grep -P '^(\d{3}-|\(\d{3}\) )\d{3}-\d{4}$' file193.txt

# sed -n -r '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/p' file193.txt

## egrep '(^([0-9]{3}) |^[0-9]{3}-)[0-9]{3}-[0-9]{4}$' file193.txt

# 194
# awk '{for(j=1;j<=NF;j++){data[NR,j]=$j;}} END {for(ii=1;ii<=NF;ii++){for(jj=1;jj<=NR;jj++){printf "%s%c", data[jj,ii],jj==NR?"\n":" ";}}}' file194.txt

## declare -a result
# while read p; do 
# 	i=0
# 	for w in $p; do
# 		if [ "x${result[$i]}" != "x" ]; then
# 			result[$i]+=" "
# 		fi
# 		result[$i]+=$w
# 		i=$(($i+1))
# 	done	
# done < file194.txt

# for l in "${result[@]}"; do
# 	echo "$l"
# done

awk '
{
    for (i = 1; i <= NF; i++) {
        if(NR == 1) {
            s[i] = $i;
        } else {
            s[i] = s[i] " " $i;
        }
    }
}
END {
    for (i = 1; s[i] != ""; i++) {
        print s[i];
    }
}' file194.txt

echo ""

# 195
sed -n '10p' < file195.txt

num=$(cat file195.txt | wc -l)
if [ $num -gt 9 ]
then
  sed -n '10p' < file195.txt
# else
#   exit
fi

awk 'NR==10' file195.txt

cat file195.txt |tail -n +10 |head -n 1

echo ""

