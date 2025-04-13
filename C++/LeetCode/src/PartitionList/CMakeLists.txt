cmake_minimum_required(VERSION 3.26)
project(PartitionList VERSION 1.0)

aux_source_directory(. SRC) # 搜索当前目录下的源文件
target_include_directories(${partition_list} PRIVATE ${LIST_HEADER_PATH}) # 指定源文件包含的头文件对应的路径
set(EXECUTABLE_OUTPUT_PATH ${EXEC_PATH}) # 设置可执行文件生成的路径
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -O0 -g")
add_executable(${partition_list} ${SRC}) # 生成可执行文件
#target_link_libraries(${partition_list} PRIVATE list)