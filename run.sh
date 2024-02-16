#!/bin/bash

docker-compose up -d

gradle_container_name="gradle"

while true; do
    if [ "$(docker inspect -f '{{.State.Running}}' "$gradle_container_name" 2>/dev/null)" == "true" ]; then
        echo "Waiting gradle build finish.."
        sleep 1
    else
        docker-compose run -i -t openjdk
        break
    fi
done
