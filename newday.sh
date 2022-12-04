#!/bin/bash

newDay="day$1"

cp -r day0 "$newDay" && 
cd "$newDay"/src/main/se/adventofcode && 
mv day0 "$newDay" &&
cd ../../../test/se/adventofcode &&
mv day0 "$newDay" &&
echo "Created new day: $newDay"
