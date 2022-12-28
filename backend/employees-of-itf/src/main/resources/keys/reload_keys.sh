#!/usr/bin/bash

openssl req -x509 -new -nodes -utf8 -sha256 -days 36500 -batch -config configuration_file.config -outform DER -out public.der -keyout private.key
openssl x509 -in public.der -inform DER -out public.key -outform PEM
rm -rf public.der
