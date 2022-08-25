#!/usr/bin/env bash

TARGET_FILE=script/deploy.sh

# 넘겨받은 인자를 변수에 저장
ACTIVE_PROFILE=${1}

# deploy.sh 스크립트 내 특정 문자열을 입력받은 인자로 대체
sed -i "s/{ACTIVE_PROFILE}/${ACTIVE_PROFILE}/g" $TARGET_FILE