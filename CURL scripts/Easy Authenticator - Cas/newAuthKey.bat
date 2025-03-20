@echo off
curl --location --request POST "https://easy-authenticator.p.rapidapi.com/newAuthKey?account=example%40example.com&issuer=example" --header "X-RapidAPI-Key: 70a86ded3fmsh28c7c8558de8c7ep16db07jsn0d0a4e3c2dfa" --header "x-rapidapi-host: easy-authenticator.p.rapidapi.com"
pause
