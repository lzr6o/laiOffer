cmake_minimum_required(VERSION 3.26)
project(FindMissingAndRepeatedValues VERSION 1.0)

aux_source_directory(. SRC) # 搜索当前目录下的源文件
set(EXECUTABLE_OUTPUT_PATH ${EXEC_PATH}) # 设置可执行文件生成的路径
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -O0 -g")
add_executable(${find_missing_and_repeated_values} ${SRC}) # 生成可执行文件
