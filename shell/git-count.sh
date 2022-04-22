#!/bin/sh
# 循环仓库目录，执行代码计算，并生成记录文件
# 循环仓库目录
# hard reset 项目，pull最新代码
# 执行git diff，记录结果到仓库目录下lines.data
# 执行git ls-files，记录结果到仓库目录下gitline.data
# 退出目录，进入下一个
for dir in */;do
  cd $dir 
  echo $dir 
  git reset --hard
  git pull
  git diff --shortstat `git hash-object -t tree /dev/null` | tail -1 > lines.data
  git ls-files | xargs wc -l | tail -1 > gitline.data
  cd ..
done