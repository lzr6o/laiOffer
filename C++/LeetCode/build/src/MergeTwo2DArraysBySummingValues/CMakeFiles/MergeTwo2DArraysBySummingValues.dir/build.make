# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.31

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Disable VCS-based implicit rules.
% : %,v

# Disable VCS-based implicit rules.
% : RCS/%

# Disable VCS-based implicit rules.
% : RCS/%,v

# Disable VCS-based implicit rules.
% : SCCS/s.%

# Disable VCS-based implicit rules.
% : s.%

.SUFFIXES: .hpux_make_needs_suffix_list

# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /opt/homebrew/bin/cmake

# The command to remove a file.
RM = /opt/homebrew/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/lzr/Desktop/laiOffer/C++/LeetCode

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/lzr/Desktop/laiOffer/C++/LeetCode/build

# Include any dependencies generated for this target.
include src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/compiler_depend.make

# Include the progress variables for this target.
include src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/progress.make

# Include the compile flags for this target's objects.
include src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/flags.make

src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/codegen:
.PHONY : src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/codegen

src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/MergeTwo2DArraysBySummingValues.cpp.o: src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/flags.make
src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/MergeTwo2DArraysBySummingValues.cpp.o: /Users/lzr/Desktop/laiOffer/C++/LeetCode/src/MergeTwo2DArraysBySummingValues/MergeTwo2DArraysBySummingValues.cpp
src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/MergeTwo2DArraysBySummingValues.cpp.o: src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green --progress-dir=/Users/lzr/Desktop/laiOffer/C++/LeetCode/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/MergeTwo2DArraysBySummingValues.cpp.o"
	cd /Users/lzr/Desktop/laiOffer/C++/LeetCode/build/src/MergeTwo2DArraysBySummingValues && /Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -MD -MT src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/MergeTwo2DArraysBySummingValues.cpp.o -MF CMakeFiles/MergeTwo2DArraysBySummingValues.dir/MergeTwo2DArraysBySummingValues.cpp.o.d -o CMakeFiles/MergeTwo2DArraysBySummingValues.dir/MergeTwo2DArraysBySummingValues.cpp.o -c /Users/lzr/Desktop/laiOffer/C++/LeetCode/src/MergeTwo2DArraysBySummingValues/MergeTwo2DArraysBySummingValues.cpp

src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/MergeTwo2DArraysBySummingValues.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Preprocessing CXX source to CMakeFiles/MergeTwo2DArraysBySummingValues.dir/MergeTwo2DArraysBySummingValues.cpp.i"
	cd /Users/lzr/Desktop/laiOffer/C++/LeetCode/build/src/MergeTwo2DArraysBySummingValues && /Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/lzr/Desktop/laiOffer/C++/LeetCode/src/MergeTwo2DArraysBySummingValues/MergeTwo2DArraysBySummingValues.cpp > CMakeFiles/MergeTwo2DArraysBySummingValues.dir/MergeTwo2DArraysBySummingValues.cpp.i

src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/MergeTwo2DArraysBySummingValues.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Compiling CXX source to assembly CMakeFiles/MergeTwo2DArraysBySummingValues.dir/MergeTwo2DArraysBySummingValues.cpp.s"
	cd /Users/lzr/Desktop/laiOffer/C++/LeetCode/build/src/MergeTwo2DArraysBySummingValues && /Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/lzr/Desktop/laiOffer/C++/LeetCode/src/MergeTwo2DArraysBySummingValues/MergeTwo2DArraysBySummingValues.cpp -o CMakeFiles/MergeTwo2DArraysBySummingValues.dir/MergeTwo2DArraysBySummingValues.cpp.s

# Object files for target MergeTwo2DArraysBySummingValues
MergeTwo2DArraysBySummingValues_OBJECTS = \
"CMakeFiles/MergeTwo2DArraysBySummingValues.dir/MergeTwo2DArraysBySummingValues.cpp.o"

# External object files for target MergeTwo2DArraysBySummingValues
MergeTwo2DArraysBySummingValues_EXTERNAL_OBJECTS =

/Users/lzr/Desktop/laiOffer/C++/LeetCode/bin/MergeTwo2DArraysBySummingValues: src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/MergeTwo2DArraysBySummingValues.cpp.o
/Users/lzr/Desktop/laiOffer/C++/LeetCode/bin/MergeTwo2DArraysBySummingValues: src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/build.make
/Users/lzr/Desktop/laiOffer/C++/LeetCode/bin/MergeTwo2DArraysBySummingValues: src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green --bold --progress-dir=/Users/lzr/Desktop/laiOffer/C++/LeetCode/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable /Users/lzr/Desktop/laiOffer/C++/LeetCode/bin/MergeTwo2DArraysBySummingValues"
	cd /Users/lzr/Desktop/laiOffer/C++/LeetCode/build/src/MergeTwo2DArraysBySummingValues && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/MergeTwo2DArraysBySummingValues.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/build: /Users/lzr/Desktop/laiOffer/C++/LeetCode/bin/MergeTwo2DArraysBySummingValues
.PHONY : src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/build

src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/clean:
	cd /Users/lzr/Desktop/laiOffer/C++/LeetCode/build/src/MergeTwo2DArraysBySummingValues && $(CMAKE_COMMAND) -P CMakeFiles/MergeTwo2DArraysBySummingValues.dir/cmake_clean.cmake
.PHONY : src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/clean

src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/depend:
	cd /Users/lzr/Desktop/laiOffer/C++/LeetCode/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/lzr/Desktop/laiOffer/C++/LeetCode /Users/lzr/Desktop/laiOffer/C++/LeetCode/src/MergeTwo2DArraysBySummingValues /Users/lzr/Desktop/laiOffer/C++/LeetCode/build /Users/lzr/Desktop/laiOffer/C++/LeetCode/build/src/MergeTwo2DArraysBySummingValues /Users/lzr/Desktop/laiOffer/C++/LeetCode/build/src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/DependInfo.cmake "--color=$(COLOR)"
.PHONY : src/MergeTwo2DArraysBySummingValues/CMakeFiles/MergeTwo2DArraysBySummingValues.dir/depend

