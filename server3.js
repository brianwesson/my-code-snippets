const http = require('http');
const httpProxy = require('http-proxy');

const servers = [
  { host: 'localhost', port: 3001 },
  { host: 'localhost', port: 3002 },
  { host: 'localhost', port: 3003 }
];

let currentServer = 0;

const proxy = httpProxy.createProxyServer();

http.createServer((req, res) => {
  currentServer = (currentServer + 1) % servers.length;

  const target = servers[currentServer];
  proxy.web(req, res, { target: `http://${target.host}:${target.port}` });
}).listen(3000);

console.log('Load balancer started on port 3000.');
