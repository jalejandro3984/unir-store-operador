FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the project files into the container
COPY . /app

# Cache dependencies
RUN --mount=type=cache,id=s/43c96632-41e3-44e3-869c-0a4ab23564de-m2/repository,target=/root/.m2/repository \
    mvn -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install
