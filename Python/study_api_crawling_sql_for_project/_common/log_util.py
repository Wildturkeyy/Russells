import time
import traceback

def ErrorLog(error: str, log_path='Log_error.txt'):
    current_time = time.strftime("%Y.%m.%d/%H:%M:%S", time.localtime(time.time()))
    with open(log_path, "a") as f:
        f.write(f"[{current_time}] - {error}\n")

def AutoLog(text: str, log_path='Log.txt'):
    with open(log_path, "a") as f:
        f.write(f"{text}\n")