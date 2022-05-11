class Promise {
  constructor(fn) {
    const resolve = (...args) => {
      if (typeof this.onDone === "function") {
        this.onDone(...args);
      }
      if (typeof this.onComplete === "function") {
        this.onConplete();
      }
    };

    const reject = (...args) => {
      if (typeof this.onError === "function") {
        this.onError(...args);
      }
      if (typeof this.onComplete === "function") {
        this.onComplete();
      }
    };
    fn(resolve, reject);
  }

  then(onDone, onError) {
    this.onDone = onDone;
    this.onError = onError;
    return this;
  }
  catch(onError) {
    this.onError = onError;
    return this;
  }
  finally(onComplete) {
    this.onomplete = onComplete;
    return this;
  }
}

//----------------------------------------------------------------
const work1 = () =>
  new Promise((resolve) => {
    setTimeout(() => resolve("작업1 완료!"), 100);
  });

const work2 = () =>
  new Promise((resolve) => {
    setTimeout(() => resolve("작업2 완료!"), 200);
  });

const work3 = () =>
  new Promise((resolve) => {
    setTimeout(() => resolve("작업 3 완료!"), 300);
  });
