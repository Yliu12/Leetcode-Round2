
function getNumDraws(year) {
    const Http = new XMLHttpRequest();
    const url='https://jsonmock.hackrank.com/api/football_matches?year=1200&page=2';
    Http.open("GET", url);
    Http.send();
}

async function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const year = parseInt(readLine().trim(), 10);

    const result =  getNumDraws(year);

    ws.write(result + '\n');

    ws.end();
}

await main();