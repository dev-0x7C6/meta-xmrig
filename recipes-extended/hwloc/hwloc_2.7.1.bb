SUMMARY = "Portable Hardware Locality (hwloc) software package"
DESCRIPTION = "The Portable Hardware Locality (hwloc) software package \
 provides a portable abstraction of the hierarchical topology of modern \
 architectures."
HOMEPAGE = "https://www.open-mpi.org/software/hwloc/"
SECTION = "base"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=79179bb373cd55cbd834463a514fb714"

SRC_URI = "https://www.open-mpi.org/software/${BPN}/v2.7/downloads/${BP}.tar.bz2"
SRC_URI[md5sum] = "903b23b6b064f497f49fcf478b3160fb"
SRC_URI[sha256sum] = "0d4e1d36c3a72c5d61901bfd477337f5a4c7e0a975da57165237d00e35ef528d"

UPSTREAM_CHECK_URI = "https://www.open-mpi.org/software/hwloc/v1.11/"

inherit autotools pkgconfig



EXTRA_OECONF += " \
  --disable-opencl \
  --disable-netloc \
  --disable-plugin-ltdl \
  --enable-plugins \
  --enable-shared \
"

PACKAGECONFIG[cairo] = "--enable-cairo,--disable-cairo,cairo,cairo"
PACKAGECONFIG[cpuid] = "--enable-cpuid,--disable-cpuid"
PACKAGECONFIG[debug] = "--enable-debug,--disable-debug"
PACKAGECONFIG[nvml] = "--enable-nvml,--disable-nvml"
PACKAGECONFIG[pci] = "--enable-pci,--disable-pci,libpciaccess pciutils,pciutils"
PACKAGECONFIG[udev] = ",--disable-udev,udev"
PACKAGECONFIG[x11] = "--with-x,--without-x,virtual/libx11"
PACKAGECONFIG[xml] = ",--disable-xml,libxml2"

DEPENDS += "ncurses udev zlib"
DEPENDS += "${@bb.utils.contains('DISTRO_FEATURES', 'selinux', 'libselinux', '', d)}"
PACKAGECONFIG ?= "pci xml udev cpuid ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11 cairo', '', d)}"

FILES:${PN} += "/usr/share/bash-completion"

# Split hwloc library into separate subpackage
PACKAGES:prepend = "libhwloc "
FILES:libhwloc += "${libdir}/libhwloc.so.*"
RDEPENDS:${PN} += "libhwloc (= ${EXTENDPKGV})"
