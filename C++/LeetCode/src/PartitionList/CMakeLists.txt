cmake_minimum_required(VERSION 3.26)
project(partitionList VERSION 1.0)

aux_source_directory(./ SRC) # 搜索当前目录下的源文件
include_directories(${HEADPATH}) # 指定源文件包含的头文件对应的路径
set(EXECUTABLE_OUTPUT_PATH ${EXECPATH})
add_library(${PARTITIONLIST} STATIC ${SRC})
