#!/bin/sh
# 循环仓库目录，按照格式输出每个仓库代码行数，后续可通过代码处理合并
# 循环仓库目录
# 输出目录名称
# 输出目录下lines.data数据
# 输出目录下gitline.data数据
# 输出分割线
# 退出当前目录，进入下一个
for dir in */;do
  cd $dir
  echo $dir
  echo diff-line: `cat lines.data | awk '{print $4}'`
  echo stat-line: `cat gitline.data | awk '{print $1}'`
  echo "-----------------------------"
  cd ..
done