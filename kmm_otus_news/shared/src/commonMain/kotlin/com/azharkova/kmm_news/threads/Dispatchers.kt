package com.azharkova.kmm_news.threads

import kotlinx.coroutines.CoroutineDispatcher

expect val ioDispatcher: CoroutineDispatcher
expect val uiDispatcher: CoroutineDispatcher