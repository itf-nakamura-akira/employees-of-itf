# [Choice] Ubuntu version (use ubuntu-22.04 or ubuntu-18.04 on local arm64/Apple Silicon): ubuntu-22.04, ubuntu-20.04, ubuntu-18.04
ARG VARIANT=ubuntu-22.04
FROM mcr.microsoft.com/vscode/devcontainers/base:0-${VARIANT}

RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
    && apt-get -y install --no-install-recommends \
    mysql-client \
    maven \
    2>&1

# Java
# RUN wget -O- https://apt.corretto.aws/corretto.key | sudo apt-key add -
# RUN sudo add-apt-repository 'deb https://apt.corretto.aws stable main'
# RUN sudo apt-get update;
# RUN sudo apt-get install -y java-17-amazon-corretto-jdk