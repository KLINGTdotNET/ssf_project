#!/bin/bash

ROOT=$(pwd)
BUILD_DIR=$ROOT/build
OUTPUT_DIR=$ROOT/output
SRC=$ROOT/src
# extension is superfluous
TEXFILE=template
XELATEX_OPTS=-halt-on-error
BIBER_OPTS=""

# sync src to build
rsync --archive --delete-before --update $SRC/ $BUILD_DIR/

# build pdf from tex
pushd $BUILD_DIR
xelatex $XELATEX_OPTS -no-pdf $TEXFILE
#biber $BIBER_OPTS $TEXFILE
#makeglossaries $TEXFILE
xelatex $XELATEX_OPTS $TEXFILE
popd

# mv output
mv $BUILD_DIR/$TEXFILE.pdf $OUTPUT_DIR/

