boolean stop = true;

while(stop){} // loops forever until something else changes the value of stop

// do the rest

obj.wait() // suspends the current thread
obj.notify()  -  obj.notifyAll() // wakes up one thread/all threads

// you are waiting on an object, for some condition to happen

"1st layer" - acquiring a lock (and waiting on that lock object)
"2st layer" - waiting for some other condityion to happen