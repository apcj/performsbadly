#!/bin/bash
mkdir out/loadingbay
for i in `ls lib/*.jar`; do
	unzip -oq $i -d out/loadingbay
done;
rm -r out/loadingbay/META-INF
unzip -oq out/artifacts/performsbadly_nodeps.jar -d out/loadingbay
jar cmf src/META-INF/MANIFEST.MF out/artifacts/performsbadly.jar -C out/loadingbay/ *

scp out/artifacts/performsbadly.jar tw-macmini@thoughtworks-macmini.local:Awayday/
