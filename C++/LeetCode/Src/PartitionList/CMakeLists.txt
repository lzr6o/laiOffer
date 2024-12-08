aux_source_directory (. SRC_LIST)

# 使用${SRC_LIST}为原材料生成一个叫做testFunc_shared 的动态库
add_library (testFunc_shared SHARED ${SRC_LIST})
# 使用${SRC_LIST}为原材料生成一个叫做testFunc_static 的静态库
add_library (testFunc_static STATIC ${SRC_LIST})

# 将testFunc_shared 重新命名为 libtestFunc.so
set_target_properties (testFunc_shared PROPERTIES OUTPUT_NAME "testFunc")
# 将testFunc_static  重新命名为 libtestFunc.a
set_target_properties (testFunc_static PROPERTIES OUTPUT_NAME "testFunc")

# 设置 库文件的默认输出路径
set (LIBRARY_OUTPUT_PATH ${PROJECT_SOURCE_DIR}/lib)
