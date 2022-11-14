
TOPDIR := $(abspath ../../../)

JNI_LIBDIR=$(TOPDIR)/target/lib
LIBNAME=$(JNI_LIBDIR)/libjni_xlib.so
SOURCES = XInternAtom.c XChangeProperty.c XDeleteProperty.c XSetClassHint.c

JNI_PACKAGE_NAME = de.metux.bindings.xlib.lowlevel

JNI_PACKAGE_DIR = $(subst .,/,$(JNI_PACKAGE_NAME))

JNI_INCLUDE_DIR = $(TOPDIR)/target/include
JNI_SRC_DIR    = $(TOPDIR)/src/main/java/$(JNI_PACKAGE_NAME)

include $(TOPDIR)/conf.mk

all: $(LIBNAME)

jni_include: $(JNI_SRC_DIR)/Xlib.java
	@mkdir -p $(JNI_INCLUDE_DIR)
	@cd $(JNI_SRC_DIR) && $(JAVAC) -h $(JNI_INCLUDE_DIR) $(abspath $<)
	@rm -f $(JNI_SRC_DIR)/*.class

$(LIBNAME): $(SOURCES) jni_include
	@mkdir -p $(dir $(LIBNAME))
	@$(CC) -shared -I$(JNI_INCLUDE_DIR) $(JAVA_CFLAGS) $(X11_CFLAGS) $(SOURCES) $(X11_LIBS) -o $@

clean:
	@rm -Rf $(LIBNAME) $(JNI_INCLUDE_DIR)
