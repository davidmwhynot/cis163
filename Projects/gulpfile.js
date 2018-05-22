const gulp = require('gulp');
const javac = require('gulp-javac');
const picard = require('child_process');

gulp.task('compile', () => {
	return gulp.src(['StopWatchPrj/src/project1/StopWatch.java', 'StopWatchPrj/src/project1/StopWatchDriver.java'])
		.pipe(javac.javac())
		.pipe(gulp.dest('StopWatchPrj/bin/project1'));
});

gulp.task('default', () => {
	gulp.watch('StopWatchPrj/src/project1/*.java', ['run']);
});

gulp.task('run', () => {
	let output = '';
	let dump = picard.spawn('./runStopWatch.sh');
	dump.stdout.on('data', (data) => {
		let dumpOut = data.toString('utf-8');
		output += dumpOut;
	});
	dump.stderr.on('data', (data) => {
		console.error(data.toString('utf-8'));
	});
	dump.on('close', (code) => {
		console.log(output);
	});
});
// gulp.task('run', ['compile'], () => {
// 	let output = '';
// 	let dump = spawn('./runStopWatch.sh');
// 	dump.stdout.on('data', (data) => {
// 		let dumpOut = data.toString('utf-8');
// 		output += dumpOut;
// 	});
// 	dump.stderr.on('data', (data) => {
// 		console.error(data.toString('utf-8'));
// 	});
// 	dump.on('close', (code) => {
// 		console.log(output);
// 	});
// });
