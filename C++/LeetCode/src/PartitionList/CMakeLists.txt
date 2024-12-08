cmake_minimum_required(VERSION 3.26)
project(partitionList VERSION 1.0)

# 搜索源文件
aux_source_directory(. SRC)
include_directories(${HEADPATH})
set(EXECUTABLE_OUTPUT_PATH ${EXECPATH})
add_executable(${PARTITIONLIST} ${SRC})
