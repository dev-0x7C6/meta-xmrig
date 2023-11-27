SUMMARY = "Optimized C library for ECDSA signatures and secret/public key operations on curve secp256k1."
DESCRIPTION = "This library is intended to be the highest quality publicly available library \
for cryptography on the secp256k1 curve. However, the primary focus of its development \
has been for usage in the Bitcoin system and usage unlike Bitcoin's may be less well tested, \
verified, or suffer from a less well thought out interface."

HOMEPAGE = "https://github.com/bitcoin-core/secp256k1"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=67330c75f8bf6a92f6f8a36ae669ba74"

SRC_URI = "git://github.com/bitcoin-core/secp256k1.git;protocol=https;branch=master"
SRCREV = "199d27cea32203b224b208627533c2e813cd3b21"

S = "${WORKDIR}/git"

inherit autotools
