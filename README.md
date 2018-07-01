# Threading

Small application to analyze how different threading strategies affect how the code is executed.

# Solutions
## Solution 1
We subscribe on the io scheduler the call to 3rd parties that require it, and inmediately onserve on main thread.
```
return external.doANetworkCall()
        .subscribeOn(Schedulers.io())
        .serveOn(AndroidSchedulers.mainThread())
```
## Solution 2
We subscribe on the io scheduler the call to 3rd parties that require it and we let the presenter onserve on main thread.
```
return external.doANetworkCall()
        .subscribeOn(Schedulers.io())
```

```
return useCase.execute(process, scenario)
        .observeOn(AndroidSchedulers.mainThread())
```
## Solution 3
We create an executor that takes care the execute the use case subscribing on io and observing on main thread. This solution fails whenever there is a 3rd party that requires running on main thread (in our example, location). On solution 4, we will see how easy it is to fix this.
```
fun execute(useCase: UseCase, process: Process, scenario: Scenario) : Completable {
        return useCase.execute(process, scenario)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
```