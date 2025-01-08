FROM quay.io/konveyor/analyzer-lsp

EXPOSE 16686

ENTRYPOINT ["sh", "-c", "all-in-one-linux &> /dev/null & sleep 5 && konveyor-analyzer --enable-jaeger && curl -o /temp/traces.json http://localhost:16686/api/traces?service=analyzer-lsp"]
