FROM gradle:latest
LABEL authors="Gustavo Henrique"

WORKDIR /home/gradle/project

COPY . ./

CMD ["gradle", "test", "--no-daemon"]