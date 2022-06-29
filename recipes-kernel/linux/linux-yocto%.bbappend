FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://msr.cfg"

MICROCODE_CONFIGS = " \
  file://microcode-amd.cfg \
  file://microcode-intel.cfg \
  file://microcode-firmware.cfg \
" 

SRC_URI:append:x86 = " ${MICROCODE_CONFIGS}"
SRC_URI:append:x86-64 = " ${MICROCODE_CONFIGS}"

