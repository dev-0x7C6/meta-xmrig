SUMMARY = "Bitcoin utils"
DESCRIPTION = "Bitcoin Core connects to the Bitcoin peer-to-peer network to download \ 
and fully validate blocks and transactions. It also includes a wallet and graphical \
user interface, which can be optionally built."

HOMEPAGE = "https://github.com/bitcoin/bitcoin.git"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=d63289bf862229a0ba143ebeadb987a3"

SRC_URI = "git://github.com/bitcoin/bitcoin.git;protocol=https;branch=24.x \
    file://0001-omit-boost-check.patch \
"
SRCREV = "b3f866a8dfd652b6339b79124843e58bd0bf3013"

S = "${WORKDIR}/git"

PR = "r1"

inherit pkgconfig autotools gettext

DEPENDS = "libsecp256k1 boost libevent util-linux-native"

EXTRA_OECONF = " \
    --with-sysroot=${STAGING_DIR_HOST} \
    --disable-bench \
    --disable-ccache \
    --disable-tests \
    --disable-gui-tests \
"

export MOC = "${STAGING_BINDIR_NATIVE}/moc"
export RCC = "${STAGING_BINDIR_NATIVE}/rcc"
export UIC = "${STAGING_BINDIR_NATIVE}/uic"

export LCONVERT = "${STAGING_BINDIR_NATIVE}/lconvert"
export LRELEASE = "${STAGING_BINDIR_NATIVE}/lrelease"
export LUPDATE = "${STAGING_BINDIR_NATIVE}/lupdate"

PACKAGECONFIG[c++20] = "--enable-c++20,--disable-c++20"
PACKAGECONFIG[qrcodes] = "--with-qrencode,--without-qrencode,qrencode"
PACKAGECONFIG[gui] = "--with-gui=qt5,--with-gui=no,qtbase qtbase-native qttools-native"
PACKAGECONFIG[zeromq] = "--enable-zmq,--disable-zmq"
PACKAGECONFIG[sqlite] = "--with-sqlite,--without-sqlite,sqlite3"
PACKAGECONFIG[bdb] = "--with-bdb --with-incompatible-bdb,--without-bdb,db"
PACKAGECONFIG[upnp] = "--with-miniupnpc,--without-miniupnpc,miniupnpd"

PACKAGECONFIG ?= "c++20 qrcodes gui zeromq sqlite bdb"
