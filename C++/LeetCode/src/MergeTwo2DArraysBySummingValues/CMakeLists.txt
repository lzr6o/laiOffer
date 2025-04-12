cmake_minimum_required(VERSION 3.26)
project(MergeTwo2DArraysBySummingValues VERSION 1.0)

aux_source_directory(./ SRC) # 搜索当前目录下的源文件
include_directories(${HEADPATH}) # 指定源文件包含的头文件对应的路径
set(EXECUTABLE_OUTPUT_PATH ${EXECPATH}) # 设置可执行文件生成的路径

# DEBUG
# -O0：禁用所有优化（确保调试时代码行为与源码完全一致）
# -g：生成调试符号（供 GDB/LLDB 使用）
# -Wall -Wextra：启用额外警告（捕获潜在问题）
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -O0 -g")

add_executable(${merge_two_2d_arrays_by_summing_values} ${SRC}) # 生成可执行文件
