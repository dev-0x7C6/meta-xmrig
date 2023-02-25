SUMMARY = "Optimized C library for ECDSA signatures and secret/public key operations on curve secp256k1."
DESCRIPTION = "This library is intended to be the highest quality publicly available library \
for cryptography on the secp256k1 curve. However, the primary focus of its development \
has been for usage in the Bitcoin system and usage unlike Bitcoin's may be less well tested, \
verified, or suffer from a less well thought out interface."

HOMEPAGE = "https://github.com/bitcoin-core/secp256k1"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=67330c75f8bf6a92f6f8a36ae669ba74"

SRC_URI = "git://github.com/bitcoin-core/secp256k1.git;protocol=https;branch=master"
SRCREV = "21ffe4b22a9683cf24ae0763359e401d1284cc7a"
PV = "0.2.0"

S = "${WORKDIR}/git"

inherit autotools
