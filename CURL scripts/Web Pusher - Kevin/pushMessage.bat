@echo off
curl --request POST
	--url https://web-pusher.p.rapidapi.com/push
	--header 'Content-Type: application/json'
	--header 'x-rapidapi-host: web-pusher.p.rapidapi.com'
	--header 'x-rapidapi-key: 789b3d4dd5msh9320c58c1ca279ap1d7cd1jsn98110b9f5fca'
	--data '{"PrivateKey":"pr34561f58cadc49fb86c7","Message":"Your message","Title":"Title","Icon":"https://webpusher.pro/webpusher.svg","Url":"https://google.com","Vibrate":"Short"}'
pause