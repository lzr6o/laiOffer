cmake_minimum_required(VERSION 3.26)
project(LeetCode VERSION 1.0)

set(CMAKE_CXX_STANDARD 11)

# 定义变量
# 静态库生成的路径
#set(LIBPATH ${PROJECT_SOURCE_DIR}/lib)
# 可执行程序的存储目录
set(EXECPATH ${PROJECT_SOURCE_DIR}/bin)
# 头文件路径
set(HEADPATH ${PROJECT_SOURCE_DIR}/include)
# 库文件的名字

# 可执行程序的名字
set(PARTITIONLIST partitionlist)
set(TWOSUM twosum)

# 给当前节点添加子目录
add_subdirectory(src)
