# DEPRECATED IN FAVOR OF [NIL V3](https://github.com/DxltaMath/Nil3)


Running:
```shell
java -jar build/Nil.jar
```


## CLI

Do not cache main.js files for over 1 second (this is unnecessarily performance intensive, for debugging only)
```shell
--no-cache
-nc
```


Cache for a certain amount of time (long, millis) (This example is for 10 minutes)
```shell
-c 600000
--cache-interval 600000
```


Never update the cache (caches the main.js ONCE, then keeps using that cache). do not use in production, the main.js will break eventually
```shell
-nu
--no-update
--never-update
```
