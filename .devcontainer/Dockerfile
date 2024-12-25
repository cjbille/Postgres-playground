FROM mcr.microsoft.com/devcontainers/base:ubuntu

SHELL ["/bin/bash", "-c"]    
USER vscode
RUN curl -s "https://get.sdkman.io" | bash \
&& source "$HOME/.sdkman/bin/sdkman-init.sh" \
&& sdk install java 21.0.5-amzn  \
&& sdk install maven 3.9.9
