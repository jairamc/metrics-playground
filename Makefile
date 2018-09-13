
.PHONY: up

prep:
	mkdir -p \
		data/whisper \
		data/elasticsearch \
		data/grafana \
		log/graphite \
		log/graphite/webapp \
		log/elasticsearch \
		log/api

clean:
    rm -rf data log

up: prep
	docker-compose up -d