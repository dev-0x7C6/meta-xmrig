SUMMARY = "Xmrig simple configuration"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://config.json.in"

RDEPENDS:${PN} += "xmrig"

do_install() {
    install -d ${D}${sysconfdir}/xmrig
    install -m 644 ${WORKDIR}/config.json.in ${D}${sysconfdir}/xmrig/config.json.in
}
