cmake_minimum_required(VERSION 3.26)
project(LeetCode VERSION 1.0)

set(CMAKE_CXX_STANDARD 11)

# 定义变量
# 静态库生成的路径
#set(LIBPATH ${PROJECT_SOURCE_DIR}/lib)
# 可执行程序的存储目录
set(EXEC_PATH ${PROJECT_SOURCE_DIR}/bin)

# 头文件路径
set(LIST_HEADER_PATH ${PROJECT_SOURCE_DIR}/include/list)
set(TREE_HEADER_PATH ${PROJECT_SOURCE_DIR}/include/tree)

# 创建静态库
add_library(list STATIC
    include/list/ListNode.h
)
add_library(tree STATIC
    include/tree/TreeNode.h
)

# 库文件的名字

# 可执行程序的名字
set(two_sum TwoSum)
set(partition_list PartitionList)
set(find_missing_and_repeated_values FindMissingAndRepeatedValues)
set(merge_two_2d_arrays_by_summing_values MergeTwo2DArraysBySummingValues)

# 给当前节点添加子目录
add_subdirectory(src)
