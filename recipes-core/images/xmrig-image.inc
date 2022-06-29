DESCRIPTION = "Core image with xmrig"

inherit core-image

IMAGE_FSTYPES += "tar"

IMAGE_INSTALL += " \
  xmrig \
  xmrig-config \
  xmrig-service \
"
