DESCRIPTION = "Core image with xmrig with tools"

require xmrig-image.inc

IMAGE_INSTALL += " \
  cpupower \
  elfutils \
  htop \
  util-linux-lscpu \
  strace \
"
