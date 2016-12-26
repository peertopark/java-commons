#!/usr/bin/env bash

source .travis/utils.sh

#if isDeployable && ( isDevelBranch || isTagRelease ); then
  if true; then
  mvn -P release --settings .travis/settings.xml deploy
  exit $?
else
  exit 0
fi
