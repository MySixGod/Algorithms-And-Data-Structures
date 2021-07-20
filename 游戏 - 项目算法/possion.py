# 泊松分布Poisson-Disc采样点的生成 算法
import d3
const width = document.querySelector('svg#d3').parentNode.clientWidth
const height = Math.round(width * 0.4)
const radius = Math.round(width / 50)

const sample = poissonDiscSampler(width, height, radius)

const svg = d3.select('svg#d3')
    .attr('width', width)
    .attr('height', height)
    .attr('viewBox', `0 0 ${width} ${height}`)
    .attr('fill', '#83887c')

const timer = d3.timer(function() {
    const s = sample()
    if (!s) return timer.stop()
    svg.append("circle")
        .attr("cx", s[0])
        .attr("cy", s[1])
        .attr("r", 0)
        .transition()
        .attr("r", 2)
})

function poissonDiscSampler(width, height, radius) {
    const k = 30,
        cellSize = radius * Math.SQRT1_2,
        gridWidthLength = Math.ceil(width / cellSize),
        gridHeightLength = Math.ceil(height / cellSize),
        grid = new Array(gridWidthLength * gridHeightLength),
        queue = []
    let queueLength = 0,
        sampleLength = 0

    return function() {
        if (!sampleLength) return sample(Math.random() * width, Math.random() * height)

        while (queueLength) {
            const i = Math.random() * queueLength | 0,
                s = queue[i]

            for (let j = 0; j < k; ++j) {
                const a = 2 * Math.PI * Math.random(),
                    r = radius * (Math.random() + 1),
                    x = s[0] + r * Math.cos(a),
                    y = s[1] + r * Math.sin(a)

                if (0 <= x && x < width && 0 <= y && y < height && far(x, y)) return sample(x, y)
            }

            queue[i] = queue[--queueLength]
            queue.length = queueLength
        }
    }

    function far(x, y) {
        let i = x / cellSize | 0,
            j = y / cellSize | 0
        const i0 = Math.max(i - 2, 0),
            j0 = Math.max(j - 2, 0),
            i1 = Math.min(i + 3, gridWidthLength),
            j1 = Math.min(j + 3, gridHeightLength)

        for (j = j0; j < j1; ++j) {
            for (i = i0; i < i1; ++i) {
                const s = grid[j * gridWidthLength + i]
                if (s) {
                    const dx = s[0] - x,
                        dy = s[1] - y
                    if (dx * dx + dy * dy < radius * radius) return false
                }
            }
        }

        return true
    }

    function sample(x, y) {
        const s = [x, y]
        queue.push(s)
        grid[gridWidthLength * (y / cellSize | 0) + (x / cellSize | 0)] = s
        ++sampleLength
        ++queueLength
        return s
    }
}