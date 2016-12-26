#!/usr/bin/env bash
source .travis/utils.sh

if isSignable; then
	openssl aes-256-cbc -K $encrypted_6c1b7104dade_key -iv $encrypted_6c1b7104dade_iv -in .travis/codesigning.asc.enc -out .travis/codesigning.asc -d
	gpg --fast-import .travis/codesigning.asc
fi
