// Created by Bob at 2025/03/20 01:29
// leetgo: dev
// https://leetcode.cn/problems/lru-cache/

#include <bits/stdc++.h>
#include <map>
#include "LC_IO.h"
using namespace std;

// @lc code=begin

struct Node
{
    int   key;
    int   val;
    Node *prev = nullptr;
    Node *next = nullptr;
    Node()
        : key(0)
        , val(0)
        , prev(nullptr)
        , next(nullptr) {};
    Node(int key, int val)
        : key(key)
        , val(val)
        , prev(nullptr)
        , next(nullptr) {};
};

class LRUCache
{
private:
    int              capacity = 0;
    map<int, Node *> cache;
    Node            *head = nullptr;
    Node            *tail = nullptr;
    void             moveToHead(Node *node)
    {
        if (node->prev == nullptr) {
            return;
        }
        node->prev->next = node->next;
        if (node->next != nullptr) {
            node->next->prev = node->prev;
        }
        else {
            this->tail = node->prev;
        }
        node->prev       = nullptr;
        node->next       = this->head;
        this->head->prev = node;
        this->head       = node;
    }
    void removeTail()
    {
        if (this->tail == nullptr) {
            return;
        }
        if (this->tail->next == nullptr && this->tail->prev == nullptr) {
            return;
        }
        int k                  = this->tail->key;
        this->tail->prev->next = nullptr;
        this->tail             = this->tail->prev;
        this->cache.erase(k);
    }

public:
    LRUCache(int capacity) { this->capacity = capacity; }

    int get(int key)
    {
        if (this->cache.find(key) == this->cache.end()) {
            return -1;
        }
        Node *node = this->cache[key];
        moveToHead(node);
        return node->val;
    }

    void put(int key, int value)
    {
        if (this->cache.find(key) == this->cache.end()) {
            Node *node       = new Node(key, value);
            this->cache[key] = node;
            if (this->head == nullptr && this->tail == nullptr) {
                this->head = node;
                this->tail = node;
            }
            else {
                node->next       = this->head;
                this->head->prev = node;
                this->head       = node;
            }
        }
        else {
            Node *node = this->cache[key];
            if (node->val != value) {
                node->val = value;
            }
            moveToHead(node);
        }

        if (this->cache.size() > this->capacity) {
            this->removeTail();
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */

// @lc code=end

int main() {
	ios_base::sync_with_stdio(false);
	stringstream out_stream;

	vector<string> method_names;
	LeetCodeIO::scan(cin, method_names);

	LRUCache *obj;
	const unordered_map<string, function<void()>> methods = {
		{ "LRUCache", [&]() {
			int capacity; LeetCodeIO::scan(cin, capacity); cin.ignore();
			obj = new LRUCache(capacity);
			out_stream << "null,";
		} },
		{ "get", [&]() {
			int key; LeetCodeIO::scan(cin, key); cin.ignore();
			LeetCodeIO::print(out_stream, obj->get(key)); out_stream << ',';
		} },
		{ "put", [&]() {
			int key; LeetCodeIO::scan(cin, key); cin.ignore();
			int value; LeetCodeIO::scan(cin, value); cin.ignore();
			obj->put(key, value);
			out_stream << "null,";
		} },
	};
	cin >> ws;
	out_stream << '[';
	for (auto &&method_name : method_names) {
		cin.ignore(2);
		methods.at(method_name)();
	}
	cin.ignore();
	out_stream.seekp(-1, ios_base::end); out_stream << ']';
	cout << "\noutput: " << out_stream.rdbuf() << endl;

	delete obj;
	return 0;
}
