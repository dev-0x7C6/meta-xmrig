SUMMARY = "Xmrig systemd service"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://xmrig.service"

inherit allarch features_check systemd

PR = "r1"

RDEPENDS:${PN} += "xmrig xmrig-config"

INHIBIT_DEFAULT_DEPS = "1"
REQUIRED_DISTRO_FEATURES = "systemd"

SYSTEMD_SERVICE:${PN} = "xmrig.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

FILES:${PN} += "${systemd_unitdir}/system"

do_install() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/xmrig.service ${D}${systemd_unitdir}/system/
}
