
JAVA_HOME   ?= /usr/lib/jvm/default-java
JAVAC       ?= $(JAVA_HOME)/bin/javac

JAVA_CFLAGS ?= -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/linux -fPIC

PKG_CONFIG  ?= pkg-config

X11_LIBS    ?= `$(PKG_CONFIG) --libs x11`
X11_CFLAGS  ?= `$(PKG_CONFIG) --cflags x11`
