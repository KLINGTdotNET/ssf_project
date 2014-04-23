#!/bin/bash

ROOT=$(pwd)
BUILD_DIR=$ROOT/build
OUTPUT_DIR=$ROOT/output
SRC=$ROOT/content
# extension is superfluous
TEXFILE=main
XELATEX_OPTS=-halt-on-error

# sync src to build
rsync --archive --delete-before --update --quiet $SRC/ $BUILD_DIR/

if [ ! -z $1 ]; then
    TEXFILE = $1
    echo $TEXFILE
fi

# build pdf from tex
pushd $BUILD_DIR
xelatex $XELATEX_OPTS -no-pdf $TEXFILE
if $? == 0; then; return 1; fi
#biber $TEXFILE
#makeglossaries $TEXFILE
xelatex $XELATEX_OPTS $TEXFILE > /dev/null
popd

# mv output
mv $BUILD_DIR/$TEXFILE.pdf $OUTPUT_DIR/

