#!/bin/bash

# Define script name to prevent self-deletion
SCRIPT_NAME="cleanup.sh"

# Delete compiled C files (excluding cleanup.sh)
find . -type f -name "*.o" -delete
find . -type f -executable ! -name "$SCRIPT_NAME" -exec rm {} +

# Delete compiled C++ files (excluding cleanup.sh)
find . -type f -name "*.o" -delete
find . -type f -executable ! -name "$SCRIPT_NAME" -exec rm {} +

# Delete compiled Java class files
find . -type f -name "*.class" -delete

# Delete compiled Kotlin JAR files
find . -type f -name "*.jar" -delete

# Confirm deletion
echo "All compiled files have been deleted!"
