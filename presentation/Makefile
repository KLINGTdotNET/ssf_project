#	Andreas Linz
#	admin@klingt.net
#

SHELL=/bin/bash

all:
	rsync --verbose --recursive --verbose content/ build/
	@./make.sh

clean:
	rm --recursive --interactive=once build/*
